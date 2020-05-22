Long last_trig = Long.parseLong(js.get("last_trig").toString());
Long cur_trig = Long.parseLong(js.get("cur_trig").toString());
float frequency = (float) 60.0;
if (last_trig + frequency*1000 > cur_trig) {  
    System.out.println("[Case 1] Too early for an alert");
}