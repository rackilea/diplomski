@PostMapping("/upload")
public ModelAndView singleFileUpload(@RequestParam("image") String image, RedirectAttributes redir) {
    jdbcTemplate.update("INSERT INTO concertphototable(ConcertId, UserId, Photo) VALUES(?, ?, ?)", 1, 1, image);
    String imageString = jdbcTemplate.queryForObject("Select Photo from concertphototable where ConcertId = " + 1,
            String.class);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:uploadStatus");
    redir.addFlashAttribute("image", imageString);
    return modelAndView;
}