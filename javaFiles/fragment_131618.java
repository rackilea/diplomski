mockMvc.perform(post("/changePass")
    .param("changePassDto.userLogName", "JOHN")
    .param("changePassDto.userLogged", "userLogged")
    .param("changePassDto.password", "password123")
    .param("changePassDto.newPassword", "newPassword123")
    .param("changePassDto.confirmNewPassword", "newPassword123"))
.andExpect(view().name(Constants.DENIED))
.andExpect(status().isOk());