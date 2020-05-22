while (rs.next()) {
        summonerUniversityDTO = new SummonerUniversityDTO();
        // Get DTO from database
        summonerUniversityDTO.setUniversityName(rs.getString("university_code"));
        summonerUniversityDTO.setID(rs.getLong("summonerId"));
        summonerUniversityDTO.setSummonerName(rs.getString("summoner_name"));

        //Add all to array
        summonerUniversityDTOArray.add(summonerUniversityDTO);
        logger.info("ARRAY" + summonerUniversityDTOArray);
        count++;
    }