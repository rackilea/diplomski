interface Socket<C extends Color> {}
interface Wire<C extends Color> {}

class RedSocket implements Socket<Red> {}
class GreenSocket implements Socket<Green> {}
class RedWire implements Wire<Red> {}
class GreenWire implements Wire<Green> {}