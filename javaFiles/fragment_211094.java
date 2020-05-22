@RequestMapping(value="/{batchid}/{phone}", method = RequestMethod.GET)
@ResponseBody
public BatchDetail  findByPhone(@PathVariable String phone, @PathVariable String batchid) {
    return batchDetailService.findByPhone(phone);

}