new Firebase('https://xxxxxxxxxx.firebaseio.com/users/' + personID).on('value', (snap) => {

    this.setState({
      name: snap.val().Name + " " +snap.val().Surname
    });

  });