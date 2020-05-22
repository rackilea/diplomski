interface Window {}
class IconWindow : Window {} //this class...
class TransientWindow : Window {} //and this one will keep a private reference to aWindowImp
interface WindowImp: Window {}
class XWindowImp : WindowImp {}
class PMWindowImp : WindowImp {}