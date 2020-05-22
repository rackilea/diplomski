List<GroupDTOv2> groupDtoList = groups.stream().map(group -> {
        GroupDTOv2 groupDTO = new GroupDTOv2();
        BeanUtils.copyProperties(group, groupDTO);
        groupDTO.setTeamLead(userMap.get(group.getTeamLeadId().toLowerCase()));
        group.getTeamMemberIds().forEach(id -> {
            groupDTO.getTeamMembers().add(userMap.get(id.toLowerCase()));
        });
        return groupDTO;
    }).collect(Collectors.toList());