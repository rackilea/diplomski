@PostMapping("/addPost")
    public String processAddPost(@ModelAttribute("post") Post post,  HttpSession session) {
         session.setAttribute("post", post);
         postService.addPost(post);
         return "redirect:/admin/listPosts";
    }