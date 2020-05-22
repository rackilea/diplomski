Parse.Cloud.define('notifyCrime', async req => {
  const query = new Parse.Query(Parse.Installation);
  query.equalTo('neighborhood', req.params.neighborhood); // I'm supposing you have a field called neighborhood in your installation class - if not, you can save this field there when the user sign up
  await Parse.Push.send({
    where: query,
    data: {
      alert: 'There is a crime in your neighborhood'
    },
    useMasterKey: true
  });
});