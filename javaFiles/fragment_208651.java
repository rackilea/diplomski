enum EVENTTYPES = {PEEL=0, WORK=1};
 struct Event = {
     int eventType;
     int* data;
 }

 filoQueue eventQueue;

 array sQuidPlayers = [new Squid(), new Squid(), new Squid()];
 void eventLoop () {
      int player;
      for each player in sQuidPlayers {
          eventQueue.push(new Event(EVENTTYPES.WORK, player.id));
      }

      for each event in eventQueue {
           game.doEvent(event)
      }

 }