class GameButton {
    var x: Float
    var y: Float
    var onClickListener: ((x: Float, y: Float)->Void)?

    func click(){
        if let cb = self.onClickListener {
            cb(x: self.x, y: self.y)
        }
    }

    init(){
        x = 1
        y = 2
    }
}


var button = GameButton()

button.onClickListener = {
    (x: Float, y: Float)->Void in

    println(x)
    println(y)
}