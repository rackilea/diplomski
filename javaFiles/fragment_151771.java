interface Window {}
class XWindow : Window {}
class PMWindow : Window {}
interface IconWindow : Window {}
class XIconWindow : XWindow, IconWindow {}
class PMIconWindow : PMWindow, IconWindow {}
interface TransientWindow : Window {}
class XTransientWIndow : XWindow, TransientWindow {}
class PMTransientWindow : PMWindow, TransientWindow {}