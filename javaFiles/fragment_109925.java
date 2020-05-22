@Override
protected String doInBackground(String... urls) {
    String result="";
    for(int i = 0; i < msg_list.size(); i++){
       Str_Msg = msg_list.get(i).getStrMsg().toString();
       Str_Phone = msg_list.get(i).getStrNumber().toString();

       Contacts person = new Contacts();
       person.setPhone(Str_Phone);
       person.setName(Str_Msg);
       result= result + POST(urls[0], person);
    }
    return result;
}