@RequestMapping(value="/result/{refNumber}", method = RequestMethod.GET)
    public String showEcustTemp ( @PathVariable("refNumber") String refNumber, Model model) {
        EcustTemp ecustTemp = ecustTempService.findByrefNumber(refNumber);
        model.addAttribute("ecustTemp", ecustTemp);
        return "userFront/daftarResult";
    }

    @RequestMapping (value="/qr/{refNumber}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getQRImage(@PathVariable String refNumber) {
        byte[] bytes = QRCode.from(ecustTempService.findByrefNumber(refNumber).getRefNumber()
                .toString()).withSize(120, 120).stream().toByteArray();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity <byte[]> (bytes, headers, HttpStatus.CREATED);
    }