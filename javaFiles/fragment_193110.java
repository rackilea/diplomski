switch(event) {
    ...
    case ON_CLICK:
    process(ViewRoot);
}

void process(View view) {

    for(View view : view.getChilds()) {
        if(view instanceOf ViewGroup && ((ViewGroup)view).getChildCount() > 0) {
             process(view);
        }
        if(view.getListenerInfo().mOnClickListener != null)
             view.getListenerInfo().mOnClickListener.onClick(view)
    }
}