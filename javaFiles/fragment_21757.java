@RequestMapping(value = "calculate", method = RequestMethod.POST)
    public JsonResponse calculate(@ModelAttribute("calcForm") @Validated CalculationForm form,
                                  BindingResult result,
                                  final RedirectAttributes redirectAttributes) {

        JsonResponse res = new JsonResponse();

            if(!result.hasErrors()) {
                    double[] ans = new double[4];
                    -----------------------------
                    -----------------------------
                    res.setResult(ans);
                    res.setStatus("SUCCESS");
                    res.setResult(userList);
            } else {
                    res.setStatus("FAIL");
                    res.setResult(result.getAllErrors());
            }

            return res;
    }