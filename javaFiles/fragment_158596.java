void run() throws Exception {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int numCMD = Integer.parseInt(br.readLine()); // note that numCMD is >= N
    int index=0;//starting index at 0
    while (numCMD-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      index++;
      int command = Integer.parseInt(st.nextToken());
      switch (command) {
        case 0: ArriveAtHospital(st.nextToken(), Integer.parseInt(st.nextToken())); 
               // you will need a index setter for this, assuming this is the moment when you add the patient to the patient list:
               ArriveAtHospìtalOrder(index);//as I cant see how the method ArriveAtHospital works, I showed you a possible method that takes the index.
               break;
        case 1: UpdateEmergencyLvl(st.nextToken(), Integer.parseInt(st.nextToken())); break;

        case 3: pr.println(Query()); break;
      }


    }
    pr.close();