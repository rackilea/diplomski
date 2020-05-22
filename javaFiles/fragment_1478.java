rule "check if user is already blacklisted 1"
agenda-group "dbcheck"
    when
        (QueryTypeDto( queryType == "blacklist" ))
        $blackListUser : BlackListUserDto(  )
        not ControlFact( blackListUserDto == $blackListUser )
        $blackListUserDto : BlackListUserDto(  )
        eval( BlackListServiceImpl.isUserBlacklisted($blackListUser) == false )
        $queryTypeDto : QueryTypeDto()
    then
        System.out.println("to be executed first");
        System.out.println($blackListUser.isBlackListFraudUser());
        modify($blackListUser){
        setBlackListFraudUser(true)
        }
        insert (new ControlFact($blackListUser));
        //$queryTypeDto.setUserBlackListed(false);
end