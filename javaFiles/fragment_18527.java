public int do_llars;
public int upg_click_cost;
public int upg_click_effect;
public int upg_click_level;

String $do_llars = ""; //String.valueOf(do_llars);
String $upg_click_cost = ""; //String.valueOf(upg_click_cost);
String $upg_click_level = ""; //String.valueOf(upg_click_level);
String $upg_click_effect = ""; //String.valueOf(upg_click_effect);

public void onTap(View view){
    if (upg_click_level == 0){
        upg_click_level = 1;
        $upg_click_level = String.valueOf(upg_click_level);
        upg_click_effect = 1;
        upg_click_effect = upg_click_level * upg_click_effect;
        $upg_click_effect = String.valueOf(upg_click_effect);
    }
    do_llars = do_llars + upg_click_effect;
    $do_llars = String.valueOf(do_llars);
    dollars.setText($do_llars);
}