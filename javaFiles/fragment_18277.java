Double xAvg = tag_info.stream()
            .collect(Collectors.averagingDouble(Tag::getX_pos));
    Double yAvg = tag_info.stream()
            .collect(Collectors.averagingDouble(Tag::getY_pos));
    Double zAvg = tag_info.stream()
            .collect(Collectors.averagingDouble(Tag::getZ_pos));