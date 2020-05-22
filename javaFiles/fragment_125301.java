@PostMapping(value="/createNewTeam")
    public Team createNewTeam(@Valid @RequestBody PayloadDto payloadDto) {
        final Player player = new Player();
        player.setPlayerName(payloadDto.playerName);
        // fill player information
        final Team team = new Team();
        // fill team information... 
        playerRepository.save(player);
        return teamRepository.save(team);
    }