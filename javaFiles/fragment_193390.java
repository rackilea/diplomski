public void write(Sequence s) {
    int i=0, j;
    int max=0;
    Vector notes=new Vector();
    try {
      Sequence s2=MidiPlayer.createSequence();
      Track tr2=s2.createTrack();
      long tlen=s.getMicrosecondLength()/s.getTickLength();
      Track[] tr=s.getTracks();
//      System.out.println("has tracks "+tr.length);
      Vector note=new Vector();
      for(i=0; i<tr.length; i++) {
        int l=tr[i].size()-1;
//      System.out.println(i+" has events "+l);
        int sum=0, start=0;
        MidiEvent mi=null;
        ShortMessage sm=null;
        byte[] dat=null;
        int tick=0, tick2=0;
        for(j=0; j<l; j++) {
          mi=tr[i].get(j);
          if(mi.getMessage().getStatus()==MetaMessage.META) { System.out.println("meta "); continue; }
          sm=(ShortMessage)mi.getMessage();
//      System.out.println("sm "+sm.getCommand()+" "+sm.getStatus()+" "+sm.getData1()+" "+sm.getData2());
          dat=sm.getMessage();
//        for(int ik=0; ik<dat.length; ik++) System.out.print(dat[ik]+" ");
//        System.out.println();
          tick2=(int)mi.getTick();
          int key=sm.getData1(), vel=sm.getData2();
        System.out.println(j+" "+(tick2-tick)+" "+tlen+" "+tick2+" "+tick+" ch "+sm.getChannel()+" "+key);
          if(j==0) { tick=tick2; continue; }
          notes.add(new int[]{key, vel, max, tick2-tick});
          max+=tick2-tick;
          tick=tick2;
          }
        }
        for(i=0; i<notes.size(); i++) {
          int[] ii=(int[])notes.get(i);
          if(ii==null) break;
          ShortMessage on = new ShortMessage();
          on.setMessage(ShortMessage.NOTE_ON, 0, ii[0], ii[1]);
          ShortMessage off = new ShortMessage();
          off.setMessage(ShortMessage.NOTE_OFF, 0, ii[0], ii[1]);
          tr2.add(new MidiEvent(on, ii[2]));
          tr2.add(new MidiEvent(off, ii[2]+ii[3]));
        }   
        String t=""+(System.currentTimeMillis()/1000);
        MidiPlayer.write(s2, "new-"+t+".mid");
    }
    catch(Exception e) { e.printStackTrace(); }
  }