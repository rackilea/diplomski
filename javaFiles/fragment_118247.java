import org.springframework.data.domain.Sort;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.PageImpl;
    import org.springframework.data.domain.Sort.Direction;
    ...    

        int page = 0;
        int count = 8;
        String sortOrder = "desc";
        String sortBy = "id";

        Sort sort = new Sort(Direction.fromString(sortOrder), sortBy);
        PageRequest pageable = new PageRequest(page, count, sort);

        List<Impianto> impiantos = myService.findMyMethod(); // returned 30 objects 
        int max = (count*(page+1)>impiantos.size())? impiantos.size(): count*(page+1);

        Page<Impianto> pageImpianto = new PageImpl<Impianto>(impiantos.subList(page*count, max), pageable, impiantos.size());