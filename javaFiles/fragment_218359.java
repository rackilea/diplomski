private Activity ctx;
private AnimatorSet sunSet;
private AnimatorSet wheelSet;

public MyAdapter(Activity ctx){
    this.ctx = ctx;
    this.sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(ctx, R.animator.sun_swing);
    this.wheelSet = (AnimatorSet) AnimatorInflater.loadAnimator(ctx, R.animator.wheel_spin);
}

public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder viewHolder = new ViewHolder();

    if (convertView == null) {
        convertView = ctx.getLayoutInflater().inflate(R.layout.drawer_list_item, parent, false);

        viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.title);
        viewHolder.txtCount = (TextView) convertView.findViewById(R.id.counter);
        convertView.setTag(viewHolder);
    }

    viewHolder = (ViewHolderItem) convertView.getTag();

    AnimatorSet sunSetClone = sunSet.clone();
    sunSetClone.setTarget(viewHolder.imgIcon);
    sunSetClone.start();

    AnimatorSet wheelSetClone = wheelSet.clone();
    wheelSetClone.setTarget(viewHolder.imgIcon);
    wheelSetClone.start();

    ObjectAnimator textAnim2 = ObjectAnimator.ofFloat(viewHolder.txtTitle, "x",convertView.getWidth()-(viewHolder.txtTitle.getWidth()/2), (convertView.getWidth()/2)-70);

    textAnim2.setDuration(1000);
    textAnim2.setRepeatCount(0);
    textAnim2.start();

    viewHolder.txtTitle.setTypeface(tf); 
    viewHolder.txtTitle.setTextSize(18);

    viewHolder.imgIcon.setImageResource(navDrawerItems.get(position).getIcon());    
    viewHolder.txtTitle.setText(navDrawerItems.get(position).getTitle());

    if(navDrawerItems.get(position).getCounterVisibility()){
        viewHolder.txtCount.setText(navDrawerItems.get(position).getCount());
    }else{
        viewHolder.txtCount.setVisibility(View.GONE);
    }

    return convertView;
}

static class ViewHolder {
    ImageView imgIcon;
    TextView txtTitle;
    TextView txtCount;
}