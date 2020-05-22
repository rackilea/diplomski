>> figure('Menubar','none', 'Position',[400 400 250 100]);
>> h = uicontrol('Style','edit', 'Position',[30 40 200 25], 'String','')
h =
    0.0101

>> drawnow; pause(0.1);
>> jh = findjobj(h, 'nomenu')
jh =
    javahandle_withcallbacks.com.mathworks.hg.peer.EditTextPeer$hgTextField


>> jedit = java(handle(jh))
jedit =
com.mathworks.hg.peer.EditTextPeer$hgTextField[...TRUNCATED STUFF...]