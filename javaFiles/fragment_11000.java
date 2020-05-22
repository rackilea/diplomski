abstract class MvpViewHolder<P :BasePresenter<P,MvpViewHolder<P>>>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        protected var presenter: P? = null
        fun bindPresenter(presenter: P) {
            this.presenter = presenter
            presenter.bindView(this)
        }

        fun unbindPresenter() {
            presenter = null
        }
    }