@Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      int x = holder.getLayoutPosition();
      // If a real name was entered (names that don't include the string <player>), set the text of the EditText to the name of the player
      if (!players.get(x).getName().contains("Player")){
          holder.playerName.setText(players.get(x).getName());
      }
      else {
          holder.playerName.setText("")
          // Keep hinting the player number (aka Player x)
          holder.playerName.setHint(players.get(position).getName());
      }
  }