@Autowired
private Playlist playlist;
@Autowired
private MyService service;

@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
public ModelAndView uploadAndParse(@RequestParam("file") MultipartFile file) {
    String name = file.getOriginalFilename();

    playlist = service.getPlaylistFromFile(file); //<--wrong step
    playlist.setCompleteName(name);

    ModelAndView view = new ModelAndView("upload", "list", playlist.getTracks());

    return view;
}