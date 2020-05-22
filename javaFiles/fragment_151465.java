@RequestMapping("/indirectAcess")
    public @ResponseBody byte[] getResource(
            @RequestParam(value="id", required=true) String idString,
            @RequestParam(value="url", required=true) String url, 
            @RequestParam(value="sig", required=true) String sig){

        try{
            int id = Integer.parseInt(idString);
            if(IndirectAccessValidate(id, url, Base64.decodeBase64(sig))){
                return "HERE IS YOUR RESOURCE".getBytes();
            }
            return null;
        } catch(Exception e){
            return "ERROR".getBytes();
        }

    }