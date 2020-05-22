@RequestMapping(value = "/CIMtrek_Compliance_Daily_Shipments_FileUpload", method = RequestMethod.POST)
public String createComments(
        @RequestParam("CIMtrek_daily_originator_comments") MultipartFile uploadItem,
        HttpServletRequest request, ModelMap map) {
    String uploadedFileName = "";

     ...

        uploadedFileName = uploadItem.getOriginalFilename();
        // ---------------------------------------------------------------------------
        if("" != uploadedFileName || null != uploadedFileName) {
            map.put("message", new String("File is uploaded."));
        } else {
            map.put("message", new String("File is not uploaded."));
        }
        // ---------------------------------------------------------------------------

    } catch (Exception e) {
        e.printStackTrace();
    }
    return uploadedFileName;
}