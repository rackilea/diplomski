void run() throws Exception {
    int seqId = 0;
    while(true) {
          List<KpiMessage> list = fullPoll(seqId);
          if (!list.isEmpty()) {
            seqId = list.get(0).getSequene();
          }
          Thread.sleep(6000); 
    }
}

public List<KAMessage> fullPoll(int lastSeq) throws Exception {
       ...
       ResultSet rs = st.executeQuery("select * from msg_new_to_bde where ACTION =  804 and SEQ > " + lastSeq + " order by SEQ 
      DESC");     
      .. 
}