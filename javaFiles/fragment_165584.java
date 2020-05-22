val sendIntent: Intent = Intent().apply {
    action = Intent.ACTION_SEND
    putExtra(Intent.EXTRA_TEXT, "press_button2")
    type = "text/plain"
}
startActivity(sendIntent)