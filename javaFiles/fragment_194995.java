with (lookupAll(".chart-legend").first()) {
    getChildList()?.clear()
    vbox {
        label("Line 1")
        label("Line 2")
        label("Line 3")
    }
}