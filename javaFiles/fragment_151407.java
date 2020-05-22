-module(latest).

-compile([export_all]).


start() ->
    P = spawn(fun() -> loop(empty) end),
    register(?MODULE,P).

loop(Last) ->
    receive
        {newpos,X} -> loop(X);
        {getpos,Pid} -> Pid ! Last, loop(empty);
        stop -> stopped
    end.
% interfaces

storepos(X) -> ?MODULE ! {newpos,X}.

getpos() -> 
    ?MODULE ! {getpos,self()},
    receive
        M -> M
    end.

stop() -> ?MODULE ! stop.

% test func

test() ->
    start(),
    P1 = spawn(fun() -> posloop(0) end),
    P2 = spawn(fun() -> clientloop() end),
    {P1,P2}.

endtest({P1,P2}) ->
    exit(P1,kill),
    exit(P2,kill),
    stop().

posloop(I) ->
    storepos(I),
    timer:sleep(random:uniform(50)),
    posloop(I+1).

clientloop() ->
    io:format("position at ~p is ~p~n",[erlang:now(),getpos()]),
    timer:sleep(random:uniform(200)),
    clientloop().