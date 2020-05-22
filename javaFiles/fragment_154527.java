@PreAuthorize("#userid == #user.id")
    @GetMapping("/update/{idpost}")
    public String showUpdateForm(
            @PathVariable int idpost, 
            @ModelAttribute("post") Post post,
            @ModelAttribute("user") User user,
            @RequestParam("u") int userid,
            Model model) {

        post = postService.findById(idpost);
        model.addAttribute("post", post);
        return "_updateForm";
    }