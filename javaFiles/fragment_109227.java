class AuctionsTodayAdapter(val context: Context, val model: MutableList<Today>) :
    RecyclerView.Adapter<AuctionsTodayAdapter.MyHolder>() {

    private var newData: Long = 0

    init {
        for (items in model) {
            items.end.let {
                newData = items.end.toLong()
            }
        }
        //set the timer which will refresh the data every 1 second.
        object : CountDownTimer(newData, 1000) {
            override fun onFinish() {
                notifyDataSetChanged()
            }

            override fun onTick(p0: Long) {
                var i = 0
                val dataLength = model.size
                while (i < dataLength) {
                    val item = model[i]
                    item.end -= 1000
                    i++
                }
                notifyDataSetChanged()
            }
        }.start()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var modelUse = model[position]
        //Img
        modelUse.image.let {
            Glide.with(context)
                .load(Constants.MAIN_BASE_URL + it)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(holder.rowMAIN_img)
        }
        //Timer
        modelUse.end.let {
            if (modelUse.calculateEnd > 0) {
                holder.rowMAIN_timer.text = getDurationBreakdown(modelUse.end.toLong())
            } else {
                holder.rowMain_timer.text = "Finished"
            }
        }
    }

    private fun millToMins(milliSec: Long): String {
        var seconds = (milliSec / 1000).toInt()
        val hours = seconds / (60 * 60)
        val tempMint = seconds - hours * 60 * 60
        val minutes = tempMint / 60
        seconds = tempMint - minutes * 60

        return String.format("%02d", hours) + ":" + String.format(
            "%02d",
            minutes
        ) + ":" + String.format("%02d", seconds)
    }
}