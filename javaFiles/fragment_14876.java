class CreateZipController extends AbstractController {
//tokenService is soemthing that you can save a future with, and return a token for - can be anything reallly...like a map.
    public ModelAndView handleRequestInternal(final HttpServletRequest request, HttpServletResponse response) throws Exception {
        Future<ZipFile> zipTask = executorService.submit(new Callable<ZipFile>(){
            public ZipFile call() {
                 return createZipFile(request);
            }
        });
        String token = tokenService.saveTask(zipTask);
        if (zipTask.isDone() {
           ModelAndView mav = new ModelAndView("downloadView");
           mav.addObject("url", getDownloadUrlFrom(zipTask.get().getName()));
           return mav;
        }
        ModelAndView mav = new ModelAndView("waitView");
        mav.addObject("message", "Please wait while zip is being created");
        mav.addObject("token", token);
        return mav;        
    }
}


class GetZipController extends AbstractController {

    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getParameter("token");
        Future<ZipFile> zipTask = tokenService.getTaskFrom(token);
        if (zipTask.isDone() {
           ModelAndView mav = new ModelAndView("downloadView");
           mav.addObject("url", getDownloadUrlFrom(zipTask.get().getName()));
           return mav;        
        } else {
           ModelAndView mav = new ModelAndView("waitView");
           mav.addObject("message", "please wait while the zip is being built");
           return mav;
        }
    }
}