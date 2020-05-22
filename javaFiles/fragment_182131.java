List<String> list = new ArrayList<String>();
while((mText = br.readLine()) != null) { 
        //Displays the contents of the file in terminal
        System.out.println(mText);
        list.add(mText); 
}