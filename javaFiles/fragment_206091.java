public void encryptMessege() throws Exception {
    List<Integer> shifts = new ArrayList<Integer>();
    StringTokenizer st = new StringTokenizer(new String(Shifts(getCharacters())));
    while(st.hasMoreTokens())
    {
        String token =st.nextToken();
        try{
            shifts.add(Integer.parseInt(token));
        }catch(NumberFormatException e)
        {
            System.out.println("did not parse: " + token);
        }
    }

    System.out.println("These are your shifts: " + shifts.toString());
}