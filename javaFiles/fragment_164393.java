@Override
public View getView(final int position, final View convertView, ViewGroup parent) {
    View row = convertView;
    final Tracker tracker = trackerList.get(position);
    final Thread thread = tracker.getThread();
    ViewHolder holder;
    long days,hours,minutes,seconds;
    long eDays,eHours,eMins,eSecs;

    if(row == null){
        holder = new ViewHolder();
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(R.layout.list_item,parent,false);
        holder.name = (TextView)row.findViewById(R.id.tvName);
        holder.days = (TextView)row.findViewById(R.id.tvDays);
        holder.hours = (TextView)row.findViewById(R.id.tvHours);
        holder.minutes = (TextView)row.findViewById(R.id.tvMinutes);
        holder.seconds = (TextView)row.findViewById(R.id.tvSeconds);
        holder.start = (ButtonFloatSmall)row.findViewById(R.id.btStart);
        holder.stop = (ButtonFloatSmall)row.findViewById(R.id.btStop);
        holder.textFinish = (TextView)row.findViewById(R.id.txtFinish);
        holder.textLimit = (TextView)row.findViewById(R.id.txtLimit);
        holder.limDay = (TextView)row.findViewById(R.id.limDay);
        holder.limHours = (TextView)row.findViewById(R.id.limHours);
        holder.limMin = (TextView)row.findViewById(R.id.limMin);
        row.setTag(holder);
    }else {
        holder = (ViewHolder) row.getTag();
    }

    //изнальначальный вид
    final ViewHolder finalHolder = holder;
    finalHolder.start.setVisibility(View.VISIBLE);
    finalHolder.stop.setVisibility(View.GONE);
    finalHolder.name.setText(tracker.getName());

    if(tracker.getElapsedTime()!=0 && tracker.getLimitTime()==0){//если прошедшее время !=0 и таймер без лимита
        days = tracker.getElapsedTime()/86400000;
        hours = (tracker.getElapsedTime()/3600000)%24;
        minutes = (tracker.getElapsedTime()/60000)%60;
        seconds = (tracker.getElapsedTime()/1000)%60;
        if(days!=0)
            finalHolder.days.setText(Util.concat(days <= 9 ? 0 : "", days));
        if(hours!=0)
            finalHolder.hours.setText(Util.concat(hours <=9 ?0:"",hours));
        if(minutes!=0)
            finalHolder.minutes.setText(Util.concat(minutes<=9?0:"",minutes));
        if(seconds!=0)
            finalHolder.seconds.setText(Util.concat(seconds<=9?0:"",seconds));
    }
    if(tracker.getIsFinished()){//если таск закончен, дошел до лимита
        hours = (tracker.getLimitTime()/3600000)%24;
        minutes = (tracker.getLimitTime()/60000)%60;
        seconds = (tracker.getLimitTime()/1000)%60;
        finalHolder.start.setVisibility(View.GONE);
        finalHolder.textFinish.setVisibility(View.VISIBLE);
        finalHolder.stop.setVisibility(View.GONE);
        if(seconds!=60)
            finalHolder.seconds.setText(Util.concat(seconds<=9?0:"",seconds));
        if(minutes!=60)
            finalHolder.minutes.setText(Util.concat(minutes<=9?0:"",minutes));
        if(hours!=24)
            finalHolder.hours.setText(Util.concat(hours <= 9 ? 0 : "", hours));

    }
    if(tracker.getLimitTime()!=0 && !tracker.getIsFinished()){//если установлен лимит, но еще не дошел до конца
        days = tracker.getLimitTime()/86400000;
        hours = (tracker.getLimitTime()/3600000)%24;
        minutes = (tracker.getLimitTime()/60000)%60;
        finalHolder.textLimit.setVisibility(View.VISIBLE);
        finalHolder.limHours.setVisibility(View.VISIBLE);
        finalHolder.limDay.setVisibility(View.VISIBLE);
        finalHolder.limMin.setVisibility(View.VISIBLE);
        finalHolder.limDay.setText(Util.concat(days <= 9 ? 0 : "", days, ":"));
        finalHolder.limHours.setText(Util.concat(hours <= 9 ? 0 : "", hours, ":"));
        finalHolder.limMin.setText(Util.concat(minutes<=9?0:"",minutes));

        eDays = (tracker.getElapsedTime() / 86400000);
        eHours = (tracker.getElapsedTime()/3600000)%24;
        eMins = (tracker.getElapsedTime()/60000)%60;
        eSecs = (tracker.getElapsedTime()/1000)%60;

        if(eSecs!=0)
            finalHolder.seconds.setText(Util.concat(eSecs<=9?0:"",eSecs));
        if(eMins!=0)
            finalHolder.minutes.setText(Util.concat(minutes<=9?0:"",eMins));
        if(eHours!=0)
            finalHolder.hours.setText(Util.concat(hours<= 9 ? 0 : "", eHours));
        if(eSecs!=0)
            finalHolder.days.setText(Util.concat(days<= 9 ? 0 : "", eDays));


    }else {
        finalHolder.textLimit.setVisibility(View.GONE);
        finalHolder.limHours.setVisibility(View.GONE);
        finalHolder.limDay.setVisibility(View.GONE);
        finalHolder.limMin.setVisibility(View.GONE);
    }

    if(tracker.getIsStart() && !tracker.getIsFinished()) {//если был стартован
        finalHolder.start.setVisibility(View.GONE);
        finalHolder.stop.setVisibility(View.VISIBLE);
    }
    tracker.setHolder(finalHolder);
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btStart:
                    tracker.setStartTime(System.currentTimeMillis());
                    tracker.setIsStart(true);
                    tracker.setHolder(finalHolder);
                    finalHolder.start.setVisibility(View.GONE);
                    finalHolder.stop.setVisibility(View.VISIBLE);
                    if(tracker.getUpdateTime()==0)
                        thread.start();
                    else
                        tracker.getThread().start();

                    break;
                case R.id.btStop:
                    tracker.setLastPause(tracker.getUpdateTime());
                    finalHolder.stop.setVisibility(View.GONE);
                    finalHolder.start.setVisibility(View.VISIBLE);
                    tracker.setIsStart(false);
                    break;

            }
        }
    };
    finalHolder.start.setOnClickListener(onClickListener);
    finalHolder.stop.setOnClickListener(onClickListener);
    return row;
}