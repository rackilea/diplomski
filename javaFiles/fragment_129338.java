new SwingBuilder().frame(pack: true, show: true, defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
    panel(layout: new BorderLayout()) {
       label constraints: BorderLayout.PAGE_START, "Header"
       button constraints: BorderLayout.PAGE_END,
           action: action(name: "Footer", closure: { println "Footer pressed" }, accelerator: "Ctrl+K" )
       list listData: 1..10, BorderLayout.CENTER 
}   }