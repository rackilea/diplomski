function connect() {
        var socket = new SockJS(/*[[@{/user}]]*/); // tricky mechanism of ThymeLeaf, produces a link attached to URL of deployed webapp with proper context
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            var subscribeUrl = '/topic/auth';
            stompClient.subscribe( subscribeUrl + '-user' + socket.sessionId, function(response){
                showMessage(response.body);
            });
        });
    }