export default Relay.createContainer(ChildComponent, {
  fragments: {
    item: () => Relay.QL`
      fragment on Item {
        id,
        name,
        color {
          id,
          name,
        }
      }
    `,
  },
});