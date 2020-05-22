private ArrayList<Result> resultList = new ArrayList<Result>();
 private Adapter_CustomList adapter = null;

 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
     View v = inflater.inflate(R.layout.frag_list_one, container, false);
     listView = (ListView) v.findViewById(R.id.frag_one_list);
     listView.setEmptyView(v.findViewById(R.id.frag_one_list_spinner));
     adapter = new Adapter_CustomList(getActivity(), resultList);
     listView.setAdapter(adapter);
 }

 @Override
 public void onStart(){
     super.onStart();
 }

 //Extended AsyncTask, essentially
 public class Fetcher extends JSONRequest{

@Override
protected void onSuccess(JSONObject req, JSONObject res){
    if (req != null && res != null){
        try{
            JSONArray jsons = res.getJSONArray("results");
            if (jsons.length() > 0){
                for (int i=0;i<jsons.length();i++){
                    JSONObject jo = jsons.getJSONObject(i);
                    r = new Result();
                    r.setLineOne(jo.getInt("line1"));
                    r.setLineTwo(jo.getString("line2"));
                    r.setLineThree(jo.getString("line3"));
                    resultList.add(r);
                }
                adapter.notifyDataSetChanged();
            } else {
                //Nothing found
            }
        } catch (JSONException e){}
    } else {
        //Null received
    }
}

@Override
protected void onError(String errMsg){}

@Override
protected void onCancel(){}

}