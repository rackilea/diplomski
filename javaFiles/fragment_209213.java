class GalleryFragment : Fragment() {
    private lateinit var viewOfLayout: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.fragment, container, false)
        viewOfLayout.imageView.setImageBitmap(bitmap) // set bitmap anywhere
        return viewOfLayout
    }
}