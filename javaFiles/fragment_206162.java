fun foo(listener:((View) -> Unit)){
    btn.setOnClickListener(listener)
}

val l={ v:View -> Log.d("View", "click")}

foo(l)