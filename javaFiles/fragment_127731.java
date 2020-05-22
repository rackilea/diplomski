onBindViewHolder

    if (mListDiscountTab.get(holder.getAdapterPosition()).getmCountDownTimer() == null) {
        mListDiscountTab.get(holder.getAdapterPosition()).setmCountDownTimer(new CountDownTimer((((mListDiscountTab.get(holder.getAdapterPosition()).getHour() * 60 * 60) + (mListDiscountTab.get(holder.getAdapterPosition()).getMinute() * 60) + (mListDiscountTab.get(holder.getAdapterPosition()).getSecond())) * 1000), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("herePOU", holder.getAdapterPosition()+"");
                long sec = (millisUntilFinished / 1000);
                mListDiscountTab.get(holder.getAdapterPosition()).setSec(sec);
                notifyDataChanged();
            }

            @Override
            public void onFinish() {
                mListDiscountTab.remove(holder.getAdapterPosition());
                notifyDataChanged();
            }
        });
        mListDiscountTab.get(holder.getAdapterPosition()).getmCountDownTimer().start();
    }

    ((ViewHolderItem) holder).tv_item_timer_hour_home_discount.setText(NumberConverter.Number_English_to_Persian(mListDiscountTab.get(holder.getAdapterPosition()).getSec() / 3600));
    ((ViewHolderItem) holder).tv_item_timer_minute_home_discount.setText(NumberConverter.Number_English_to_Persian(((mListDiscountTab.get(holder.getAdapterPosition()).getSec() % 3600) / 60)));
    ((ViewHolderItem) holder).tv_item_timer_second_home_discount.setText(NumberConverter.Number_English_to_Persian((mListDiscountTab.get(holder.getAdapterPosition()).getSec() % 3600) % 60));