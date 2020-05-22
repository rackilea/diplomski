public void deleteCustomer(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    boolean wasDeleted = customerService.delete(id);
    if(!wasDeleted)
        response.sendError(503, "No Customer found for ID : " + id);
    }
}