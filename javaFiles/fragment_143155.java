@Override
public void onClick(View view) {
    if(view.getId()==R.id.btndayOV){

        OrderVelocityFragment fragment = new OrderVelocityFragment().newInstance(whareHouse,whareHouseName,"day");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame_home, fragment)
                .commit();

        day.setTextColor(Color.WHITE);
        day.setBackgroundResource(R.color.orderVelocity);
        hour.setBackgroundResource(R.color.orderVelocityLight);
        minute.setBackgroundResource(R.color.orderVelocityLight);
        week.setBackgroundResource(R.color.orderVelocityLight);
    }
    else if(view.getId()==R.id.btnHourOV){

        OrderVelocityFragment fragment = new OrderVelocityFragment().newInstance(whareHouse,whareHouseName,"hour");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame_home, fragment)
                .commit();

        hour.setTextColor(Color.WHITE);
        day.setBackgroundResource(R.color.orderVelocityLight);
        hour.setBackgroundResource(R.color.orderVelocity);
        minute.setBackgroundResource(R.color.orderVelocityLight);
        week.setBackgroundResource(R.color.orderVelocityLight);
    }
    else if(view.getId()==R.id.btnMinuteOV){

        OrderVelocityFragment fragment = new OrderVelocityFragment().newInstance(whareHouse,whareHouseName,"minute");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame_home, fragment)
                .commit();

        minute.setTextColor(Color.WHITE);
        day.setBackgroundResource(R.color.orderVelocityLight);
        hour.setBackgroundResource(R.color.orderVelocityLight);
        minute.setBackgroundResource(R.color.orderVelocity);
        week.setBackgroundResource(R.color.orderVelocityLight);
    }
    else if(view.getId()==R.id.btnWeekOV){

        OrderVelocityFragment fragment = new OrderVelocityFragment().newInstance(whareHouse,whareHouseName,"week");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame_home, fragment)
                .commit();

        week.setTextColor(Color.WHITE);
        day.setBackgroundResource(R.color.orderVelocityLight);
        hour.setBackgroundResource(R.color.orderVelocityLight);
        minute.setBackgroundResource(R.color.orderVelocityLight);
        week.setBackgroundResource(R.color.orderVelocity);
    }
}