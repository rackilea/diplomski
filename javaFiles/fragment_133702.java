<tr 
    className="song" key={index} 
    onClick={() => this.handleSongClick(song)}
    onMouseOver={() => this.handleOnHover(song)}
    onMouseOut={() => this.handleOnHover(song)}
>
      <td className="song-actions">
         <button>
            <span className="song-number">
                {!this.state.showPlayOnHover ? index+1 : <span className="ion-play"></span>}
            </span>
            <span className="ion-play"></span>
            <span className="ion-pause"></span>
        </button>
      </td>
      <td className="song-title">{song.title}</td>
      <td className="song-duration">{song.duration}</td>
</tr>