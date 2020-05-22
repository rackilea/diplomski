class myVC: UIViewController {
   var locationManagerDelegate = SomethingImplementingTheDelegate()
}

class SomethingImplementingTheDelegate: CLLocationManagerDelegate {
    func locationManager(manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) { /*...*/ }
}