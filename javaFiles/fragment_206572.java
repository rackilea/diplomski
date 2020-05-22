export default Relay.createContainer(ParentComponent, {
  fragments: {
    itemList: () => Relay.QL`
      fragment on Item @relay(plural:true) {
        ${ChildComponent.getFragment('item')}
      }
    `,
  },
});