class ViewController: UIViewController
{
    @IBOutlet weak var imageView: UIImageView!

    override func viewDidLoad() {
        super.viewDidLoad()

        if let url = NSURL(string: "https://mozorg.cdn.mozilla.net/media/img/firefox/new/header-firefox-high-res.d121992bf56c.png") {
            let task = NSURLSession.sharedSession().dataTaskWithRequest(NSURLRequest(URL: url)) { (data, response, error) -> Void in
                if error == nil && data != nil { // Needs better error handling based on what your server returns
                    if let image = UIImage(data: data!) {
                        dispatch_async(dispatch_get_main_queue()) {
                            self.imageView.image = image
                        }
                    }
                }
            }
            task.resume()
        }
    }
}